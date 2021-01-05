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
			list.add(new DemoDto(idini+1, idini, "comentario "+ numComentario));
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
		list.add(new DemoDto(2, 1, "comentario 11"));
		list.add(new DemoDto(4, 3, "comentario 12"));
		list.add(new DemoDto(6, 5, "comentario 13"));
		list.add(new DemoDto(8, 7, "comentario 14"));
		
		return list;
	}

}
