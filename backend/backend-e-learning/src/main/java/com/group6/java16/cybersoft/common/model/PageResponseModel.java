package com.group6.java16.cybersoft.common.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageResponseModel<T> {
	private int pageCurrent;
	private int totalPage;
	private List<T> items = new ArrayList<>();

}