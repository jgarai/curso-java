package com.dictionary.presentacion;

import java.time.LocalDateTime;

import com.dictionary.entidades.User;

@SuppressWarnings("unused")
public class PresentacionUserConsola {
	public static void main(String[] args) {
		User u = new User(null, "nombre@email.com", "c00lPa$$Word", "IamHowIam", null, null );
		
		System.out.println(u);
				
			

	}

}
