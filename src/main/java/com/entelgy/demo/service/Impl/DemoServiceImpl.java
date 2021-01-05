package com.entelgy.demo.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.entelgy.demo.dto.DemoDto;
import com.entelgy.demo.dto.RequestDto;
import com.entelgy.demo.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService {

	@Override
	public List<DemoDto> listarComentariosConInput(RequestDto requestDto) {
		
		//aqui podria consultarse a un DAO para obtener la lista
		
		List<DemoDto> list = new ArrayList<DemoDto>();
		int idini = new Random().nextInt(10);
		int numComentario;
		for (int i = 0; i < requestDto.getCantidad(); i++) {
			idini = new Random().nextInt(requestDto.getLlaveId());
			numComentario = new Random().nextInt(requestDto.getLlaveComentario());
			list.add(new DemoDto(idini+1, idini, "correo"+ numComentario + "@prueba.com"));
		}
		return list;
	}
	
	@Override
	public List<DemoDto> listarComentarios() {
		
		//aqui podria consultarse a un DAO para obtener la lista
		
		List<DemoDto> list = new ArrayList<DemoDto>();
//		int idini = new Random().nextInt(10);
//		int numComentario = new Random().nextInt(1000);
//		for (int i = 0; i < 10; i++) {
//			list.add(new DemoDto(idini+1, idini, "comentario "+ numComentario));
//		}
		list.add(new DemoDto(2, 1, "correo11@prueba.com"));
		list.add(new DemoDto(4, 3, "correo11@prueba.com"));
		list.add(new DemoDto(6, 5, "correo11@prueba.com"));
		list.add(new DemoDto(8, 7, "correo11@prueba.com"));
		
		return list;
	}

}
