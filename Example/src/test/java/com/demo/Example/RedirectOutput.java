package com.demo.Example;



public class RedirectOutput {
	public static void main(String[] args) throws Exception {
		double pie = 3.141592;
		String formatted_output = String.format("Value of pie: %10.2f", pie);
		System.out.println(formatted_output);

	}
}
