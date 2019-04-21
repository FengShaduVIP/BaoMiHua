package com.baomihua.utils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

public class FileUtils {

	private static Logger logger = Logger.getLogger(FileUtils.class);




	public static void saveFile(MultipartFile uploadFile,
			String filePath, String fileName) {
		logger.info("文件名称： "+fileName);
		filePath = filePath + File.separator+ fileName;
		logger.info("文件路径--"+filePath);
		File file = new File(filePath);
		if (file.exists())
			file.delete();
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		try {
			InputStream inputStream = uploadFile.getInputStream();
			byte[] b = new byte[1024 * 1024];
			int length = inputStream.read(b);
			FileOutputStream outputStream = new FileOutputStream(filePath);
			outputStream.write(b, 0, length);
			file.setExecutable(true);// 设置可执行权限
			file.setReadable(true);// 设置可读权限
			file.setWritable(true);// 设置可写权限
			inputStream.close();
			outputStream.close();
		} catch (Exception e) {
			logger.error(e);
		}
		logger.info("文件保存成功");
	}

	/**
	 * 保存某段内容到文件
	 *
	 */
	public static void updateFile(String filePath, String fileName, String content)
			throws IOException {
		String TI_KU = UploadUtils.getConfig("FILE_PATH")+File.separator+"TI_KU";
		File file = new File(filePath);
		if (!(file.getParentFile().exists() && file.getParentFile().isDirectory())) {
			//不存在则尝试自动创建
			if(!file.getParentFile().mkdirs()){
				throw new NullPointerException(File.separator + (filePath) +" folder does not exist");
			}
		}
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
		dos.close();
		file.delete();
		logger.info("文件路径： " + filePath);
		file.setExecutable(true);// 设置可执行权限
		file.setReadable(true);// 设置可读权限
		file.setWritable(true);// 设置可写权限
		FileWriter filewriter = new FileWriter(file, true);
		BufferedWriter bufwriter = new BufferedWriter(filewriter);
		filewriter.write(content);
		filewriter.flush();
		bufwriter.close();
	}


	/**
	 * 获取txt文件内容并按行放入list中
	 */
	public static List<String> getFileContext(String path) throws Exception {
		FileReader fileReader = new FileReader(path);
		BufferedReader bufferedReader =new BufferedReader(fileReader);
		List<String> list =new ArrayList<String>();
		String str=null;
		while((str=bufferedReader.readLine())!=null) {
			if(str.trim().length()>2) {
				if(str.contains("@"))

				list.add(str);
			}
		}
		return list;
	}

	/**
	 * 根据 标志分割字符串
	 * @param str
	 * @param num
	 * @return
	 */
	public static String getSubStr(String falg,String str, int num) {
		String result = "";
		int i = 0;
		while(i < num) {
			int lastFirst = str.lastIndexOf(falg);
			result = str.substring(lastFirst) + result;
			str = str.substring(0, lastFirst);
			i++;
		}
		return result.substring(1);
	}


	/**
	 * 根据url 下载文件
	 * @param str url 路径
	 * @param toPath 文件存储路径
	 */
	public void downloadFileFromUrl(String str,String toPath){
		URL url = null;
		try {
			url = new URL(str);
			DataInputStream dataInputStream = new DataInputStream(url.openStream());

			FileOutputStream fileOutputStream = new FileOutputStream(new File(toPath));
			ByteArrayOutputStream output = new ByteArrayOutputStream();

			byte[] buffer = new byte[1024];
			int length;

			while ((length = dataInputStream.read(buffer)) > 0) {
				output.write(buffer, 0, length);
			}
			fileOutputStream.write(output.toByteArray());
			dataInputStream.close();
			fileOutputStream.close();
			logger.info("地址: "+str+" 下载成功！");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 从文本文件中读取内容
	 * 
	 * @param path
	 * @return
	 */
	public static String readfile(String path) {
		String readStr = "";
		try {
			File file = new File(path);
			FileReader fileread = new FileReader(file);
			BufferedReader bufread = new BufferedReader(fileread);
			String read = null;
			while ((read = bufread.readLine()) != null) {
				readStr = readStr + read + '\n';
			}
			bufread.close();
		} catch (Exception d) {
			logger.error(d.getMessage());
		}
		return readStr; // 返回从文本文件中读取内容
	}

	/**
	 * 把10位时间戳数字转成字符串(混合大小写)
	 *
	 * @param num
	 * @return
	 */
	private static String n2s(int num) {
		String str = "";
		char _char;
		String numStr = String.valueOf(num);
		for (int i = 0; i < numStr.length(); i++) {
			int n = Integer.parseInt(numStr.substring(i, i + 1));
			if (n <= 2) { // 这里最后一组只保留xyz不转换，用来做分隔符
				_char = (char) (n + 65 + rand(0, 3) * 10 + rand(0, 2) * 32);
			} else {
				_char = (char) (n + 65 + rand(0, 2) * 10 + rand(0, 2) * 32);
			}
			str += _char;
		}
		return str;
	}

	/**
	 * 产生随机整数,范围[m,n)
	 *
	 * @return
	 */
	private static int rand(int m, int n) {
		return (int) (Math.random() * (n - m) + m);
	}

	public static String ImgName() {
		return n2s(UploadUtils.getNowTimestamp());
	}

}
