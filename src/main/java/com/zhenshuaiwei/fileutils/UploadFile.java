/**
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: UploadFile.java 
 * @Prject: zhenshuaiwei-utils
 * @Package: com.zhenshuaiwei.utils 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月26日 下午3:53:40 
 * @version: V1.0  
 */
package com.zhenshuaiwei.fileutils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/** 
 * @ClassName: UploadFile 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月26日 下午3:53:40  
 */
public class UploadFile {

	//文件的全扩展名
	private String fileName;
	//要下载的目标路径
	private String uploadPath;
	//文件的新全扩展名字
	private String newName;
	//文件的新地址,也是文件在指定文件夹下的地址
	private String newUrl;
	//文件的全路径
	private String newAllUrl;
	//生成的新文件
	private File newFile;
	//文件的扩展名suffixName
	private String suffixName;
	
	
	//获取文件的新名字
	private void initNewName() {
		File file = new File(fileName);
		//求扩展名
		this.suffixName = file.getName().substring(file.getName().lastIndexOf('.'));
		String fileNamePre = UUID.randomUUID().toString();
		//新的名字
		this.newName = fileNamePre+this.suffixName;
	}
	
	
	//文件的目标下的路径
	private void initNewDateUrl() {
		//上传日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String date = sdf.format(new Date());
		File pathFile = new File(this.uploadPath+"/"+date);
		//判断文件路径是否存在
		if(!pathFile.exists()){
			pathFile.mkdirs();
		}
		this.newUrl = date+"/"+this.newName;
		this.newAllUrl = this.uploadPath+"/"+this.newUrl;
		this.newFile = new File(this.newAllUrl);
	}
	
	private void initNewUrl() {
		this.newAllUrl = this.uploadPath+"/"+this.newName;
		this.newFile = new File(this.newAllUrl);
	}
	


	
	
	/**
	 * 
	 * @Title: getFileName 
	 * @Description: 文件的全扩展名
	 * @return
	 * @return: String
	 * @date: 2019年11月26日下午4:28:32
	 */
	public String getFileName() {
		return fileName;
	}

	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * 
	 * @Title: getUploadPath 
	 * @Description: 要下载的目标路径
	 * @return
	 * @return: String
	 * @date: 2019年11月26日下午4:29:07
	 */
	public String getUploadPath() {
		return uploadPath;
	}


	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	/**
	 * 
	 * @Title: getNewName 
	 * @Description: 文件的新全扩展名字
	 * @return
	 * @return: String
	 * @date: 2019年11月26日下午4:29:17
	 */
	public String getNewName() {
		return newName;
	}


	public void setNewName(String newName) {
		this.newName = newName;
	}

	/**
	 * 
	 * @Title: getNewUrl 
	 * @Description: 文件在指定文件夹下的地址
	 * @return
	 * @return: String
	 * @date: 2019年11月26日下午4:29:39
	 */
	public String getNewUrl() {
		return newUrl;
	}


	public void setNewUrl(String newUrl) {
		this.newUrl = newUrl;
	}

	/**
	 * 
	 * @Title: getNewAllUrl 
	 * @Description: 文件的全路径
	 * @return
	 * @return: String
	 * @date: 2019年11月26日下午4:30:04
	 */
	public String getNewAllUrl() {
		return newAllUrl;
	}


	public void setNewAllUrl(String newAllUrl) {
		this.newAllUrl = newAllUrl;
	}


	public File getNewFile() {
		return newFile;
	}


	public void setNewFile(File newFile) {
		this.newFile = newFile;
	}


	/**
	 * 
	 * @Title: getSuffixName 
	 * @Description: 文件的扩展名
	 * @return
	 * @return: String
	 * @date: 2019年11月26日下午4:30:19
	 */
	public String getSuffixName() {
		return suffixName;
	}


	public void setSuffixName(String suffixName) {
		this.suffixName = suffixName;
	}


	private UploadFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @Title: uploadDateFile 
	 * @Description: 在目标路径下生成一个以当前日期命名新的文件夹,将文件下载在这个文件夹下
	 * @param fileName
	 * @param uploadPath
	 * @return
	 * @return: UploadFile
	 * @date: 2019年11月26日下午4:46:19
	 */
	public static UploadFile uploadDateFile(String fileName, String uploadPath) {
		UploadFile uploadFile = new UploadFile();
		uploadFile.setFileName(fileName);
		uploadFile.setUploadPath(uploadPath);
		uploadFile.initNewName();
		uploadFile.initNewDateUrl();
		return uploadFile;
	}
	
	/**
	 * 
	 * @Title: uploadFile 
	 * @Description: 将文件以新名字存入目标路径
	 * @param fileName
	 * @param uploadPath
	 * @return
	 * @return: UploadFile
	 * @date: 2019年11月26日下午4:47:12
	 */
	public static UploadFile uploadFile(String fileName, String uploadPath) {
		UploadFile uploadFile = new UploadFile();
		uploadFile.setFileName(fileName);
		uploadFile.setUploadPath(uploadPath);
		uploadFile.initNewName();
		uploadFile.initNewUrl();
		return uploadFile;
	}


	
	
	
}
