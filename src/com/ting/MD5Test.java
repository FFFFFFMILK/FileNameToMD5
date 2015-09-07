package com.ting;

import java.io.File;
import java.util.ArrayList;

public class MD5Test {
	public static void main(String[] args) {
//		System.out.println(MD5Utils.stringToMD5("wangting"));
//		long startTime = System.currentTimeMillis();
//		System.out.println(MD5Utils.fileToMD5("/Users/Fu/GitHub/LICENSE"));
//		long endTime = System.currentTimeMillis();
//		System.out.println("Time:" + (endTime - startTime) / 1000);
		
		 ArrayList<File> files= getListFiles("/Users/Fu/Desktop/mozik"); 
		 filesToMD5(files);
	}
	
	
	public static File getFileNameFromDirectionary(String sourcePath){
		File directionary = new File(sourcePath);
		System.out.println("是目录吗？"+directionary.isDirectory());
		System.out.println("名称："+directionary.getName());
		
		return directionary;
	}
	
	/***
	 * 获取指定目录下的所有的文件（不包括文件夹），采用了递归
	 * 
	 * @param obj
	 * @return
	 */
	public static ArrayList<File> getListFiles(Object obj) {
		File directory = null;
		if (obj instanceof File) {
			directory = (File) obj;
		} else {
			directory = new File(obj.toString());
		}
		ArrayList<File> files = new ArrayList<File>();
		if (directory.isFile()) {
			//if(directory.toString().split(".")[1] == "mp3"){
				System.out.println("名称："+directory.getName());
				files.add(directory);
				return files;
			//}	
		} else if (directory.isDirectory()) {
			File[] fileArr = directory.listFiles();
			for (int i = 0; i < fileArr.length; i++) {
				File fileOne = fileArr[i];
				files.addAll(getListFiles(fileOne));
			}
		}
		return files;
	}
	
	public static void filesToMD5(ArrayList<File> files){
		for (int i = 0; i < files.size(); i++){
			String s = MD5Utils.fileToMD5(files.get(i)).substring(0, 8).trim();
			files.get(i).renameTo(new File("/Users/Fu/Desktop/mozik/" + s + ".mp3"));
		}
	}
	
}
