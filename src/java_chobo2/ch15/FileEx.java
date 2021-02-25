package java_chobo2.ch15;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

public class FileEx {

	public static void main(String[] args) throws IOException {
//		File f = new File("D:\\workspace\\native_jdbc_programming\\src\\native_jdbc_programming\\dto");
		File f = getSearchFile();

		String fileName = f.getName();
		int pos = fileName.lastIndexOf(".");

		System.out.println("경로를 제외한 파일 이름 - " + f.getName());
		System.out.println("확장자를 제외한 파일 이름 - " + fileName.substring(0, pos));
		System.out.println("확장자 -" + fileName.substring(pos + 1));

		System.out.println("경로를 포함한 파일 이름 -" + f.getPath());
		System.out.println("파일의 절대경로            -" + f.getAbsolutePath());
		System.out.println("파일의 정규경로            -" + f.getCanonicalPath());
		System.out.println("파일이 속해 있는 디렉토리 - " + f.getParent());
		System.out.println();
		System.out.println("File.pathSeparator -" + File.pathSeparator);
		System.out.println("File.pathSeparatorChar -" + File.pathSeparatorChar);
		System.out.println("File.separtor - " + File.pathSeparator);
		System.out.println("File.pathSeparatorChar -" + File.pathSeparatorChar);
		System.out.println();
		System.out.println("user.dir=" + System.getProperty("user_dir"));
		System.out.println("sun.boot.class.path=" + System.getProperty("sun.boot.class.path"));

	}

	
	static File getSearchFile() {
		JFileChooser jfc = new JFileChooser(System.getProperty("user.dir"));
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		
		int res = jfc.showOpenDialog(null);
		File file = null;
		if (res == JFileChooser.APPROVE_OPTION) {
			file = jfc.getSelectedFile();
			System.out.println(file.getAbsolutePath());
		}
		return file;
	}

}
