package com.parishservice.parishservice.Controller;


import com.parishservice.parishservice.Entity.Parish;
import com.parishservice.parishservice.Service.ParishServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(
        name="Parish Controller",
        description = "Parish Controller exposes Rest Api for Parish service"
)
@RestController
@AllArgsConstructor
@RequestMapping("api/parish")
public class ParishController {
    @Autowired
    private ParishServiceImp parishServiceImp;


    @Autowired
    private Environment environment;

    @GetMapping("/{id}")
    public ResponseEntity<Parish> getParishByIdGet(@PathVariable Long id) {
        return ResponseEntity.ok(parishServiceImp.getParishById(id));
    }

    @GetMapping
    public ResponseEntity<List<Parish>>getAllParishData(){

        return new ResponseEntity<>(parishServiceImp.getAllParishData(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Parish>createParish(@RequestBody Parish parish){
        Parish parish1 = parishServiceImp.saveParish(parish);

        return ResponseEntity.ok(parish1);
    }
    @PutMapping("/{id}/update")
    public ResponseEntity<Parish>updateParish(@PathVariable Long id, @RequestBody Parish parish){
        return ResponseEntity.ok(parishServiceImp.updateParishData(id, parish));
    }

    @DeleteMapping
    public ResponseEntity<String>deleteParish(){
        parishServiceImp.deleteParish();
        return new ResponseEntity<>("Parish Deleted", HttpStatus.OK);
    }


    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> getParishById(@PathVariable Long id) {
        parishServiceImp.deleteParishById(id);
        return new ResponseEntity<>("Parish Deleted", HttpStatus.OK);
    }

    @GetMapping("/get")
    public void get(){
        String[] env = environment.getActiveProfiles();


        for (String e : env) {
            System.out.println(e);
        }
    }

}
