package lk.sahan.dev.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sun.deploy.net.HttpResponse;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import lk.sahan.dev.dto.CustomerDTO;
import lk.sahan.dev.service.CustomerService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.annotation.XmlMimeType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

import java.net.URLConnection;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerS;

    @GetMapping
    public List<CustomerDTO> allCustomers(){
        return customerS.findAll();
    }

//    @GetMapping
//    public String get(){
//
//        return "Back End eken Awe";
//    }
    @GetMapping("/{id}")
    public CustomerDTO findByID(@PathVariable("id") String id){

        return customerS.findById(id);
    }

//    @PutMapping(value = "/{id}")
//    public void saveCustomer(@PathVariable("id") String id, @RequestBody CustomerDTO customerDTO){
//        System.out.println(id);
//
//        customerS.saveCustomer(id,customerDTO);
//
//    }

    @PutMapping(value = "/{id}")
    public boolean saveCustomer(@PathVariable("id") String id, @RequestParam("fileName") String fileName, @RequestParam("user")String user) throws IOException {
        CustomerDTO customerDTO = null;

//        System.out.println(file.getBytes());/
        try {
             customerDTO = new ObjectMapper().readValue(user,CustomerDTO.class);

            customerDTO.setImageName(fileName);
            customerS.saveCustomer(id,customerDTO);

            System.out.println(customerDTO);
            return true;
        } catch (IOException e) {
            e.printStackTrace();

            return false;
        }

    }
    @PostMapping(value = "/{id}")
    public boolean updateCustomer(@PathVariable("id") String id, @RequestParam("fileName") String fileName, @RequestParam("user")String user){
        CustomerDTO customerDTO = null;
        try {
            customerDTO = new ObjectMapper().readValue(user,CustomerDTO.class);

            customerDTO.setImageName(fileName);
            customerS.updateCustomer(id,customerDTO);

            System.out.println(customerDTO);
            return true;
        } catch (IOException e) {
            e.printStackTrace();

            return false;
        }
    }
    @DeleteMapping(value = "/{id}")
    public boolean deleteCUstomer(@PathVariable("id") String id){
        return customerS.deleteCustomer(id);
    }


    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveFile(@RequestPart("file") MultipartFile myFile){

        System.out.println(myFile.getOriginalFilename());
        try {

            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getAbsolutePath();

            File uploadDir = new File(projectPath + "/uploads");
            uploadDir.mkdir();
            System.out.println(uploadDir.getAbsolutePath());
            myFile.transferTo(new File(uploadDir.getAbsolutePath()+"/"+myFile.getOriginalFilename()));
            System.out.println("File Path "+uploadDir.getAbsolutePath()+"/"+myFile.getOriginalFilename());

            String imgUrl = "../../../../../BackEnd/target/POS-1.0.0/WEB-INF/classes/uploads/"+myFile.getOriginalFilename();

            System.out.println(imgUrl);
            return  true;



        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @GetMapping(path="/getFile",produces = {"image/jpeg","image/png"})
    public byte[] getFile(@RequestParam("fileName")String fileName){

        try {
            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getAbsolutePath();
            File file = new File(projectPath + "/uploads/" + fileName);
            FileInputStream fileInputStream = new FileInputStream(file);

           String mimeType= URLConnection.guessContentTypeFromName(file.getName());
            System.out.println(mimeType);

            byte[] bytes = IOUtils.toByteArray(fileInputStream);
            return bytes;


        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }


}
