package com.entelgy.demo.service;

import java.util.List;

import com.entelgy.demo.dto.DemoDto;
import com.entelgy.demo.dto.RequestDto;

public interface DemoService {

	List<DemoDto> listarComentariosConInput(RequestDto requestDto);
	List<DemoDto> listarComentarios();

}
