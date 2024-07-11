package com.kh.practice1;

import java.util.Scanner;

import com.kh.practice1.controller.SongManager_Copy;

public class Application_copy {
	
	public static void main(String[] args) {
		SongManager_Copy smc = new SongManager_Copy();
		Scanner sc = new Scanner(System.in);
		while(true) {
		smc.mainmenu();
		int num = smc.mainInput();
		smc.mainSelect(num);
		}
	}

}
