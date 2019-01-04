package com.eriz.mybatisGen.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 *2018年12月11日 eriz
 */
@Service
public interface GeneratorService {
	List<Map<String, Object>> list();

	byte[] generatorCode(String[] tableNames);
}
