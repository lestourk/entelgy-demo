package com.entelgy.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entelgy.demo.dto.DemoDto;
import com.entelgy.demo.dto.RequestDto;
import com.entelgy.demo.service.DemoService;

@RestController
@RequestMapping("/entelgy")
public class DemoController {

	@Autowired
	private DemoService demoService;

//	private final DemoService demoService;
//
//    public DemoController(final DemoService demoService) {
//        this.demoService = demoService;
//    }
    
//	@PostMapping("/comments")
//	ResponseEntity<List<DemoDto>> postResultado(@RequestBody RequestDto requestDto) {
//		return ResponseEntity.ok(demoService.listar(requestDto));
//	}
	
	@PostMapping("/commentsConArgs")
    public ResponseEntity<List<DemoDto>> listarComentariosConInput(@RequestBody RequestDto requestDto) {
        return new ResponseEntity<>(demoService.listarComentariosConInput(requestDto), HttpStatus.OK);
    }
	@PostMapping("/commentsSinArgs")
    public ResponseEntity<List<DemoDto>> listarComentariosSinInput() {
        return new ResponseEntity<>(demoService.listarComentarios(), HttpStatus.OK);
    }

	
//	@GetMapping(value = "/comments2")
//	ResponseEntity<List<DemoDto>> listarCommentarios2() {
//		return ResponseEntity.ok(demoService.listar(new RequestDto()));
//	}
}
