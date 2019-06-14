package com.group23.minir.core;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
* ���������Ĺ�����
* @author Group 23
* @version 1.0
*/
public class Renamer {

	private String dir;
	private String reg;
	private int begin;
	private int step;
	private String prefix;
	private String suffix;

	private List<File> files = new LinkedList<File>();

	private int result = 0;

	/**
	 * ���췽��
	 * @param dir �������ļ�����Ŀ¼
	 * @param reg ѡ���ļ���ʹ�õ�������ʽ
	 * @param begin ��ʼ���
	 * @param step ��Ų���
	 * @param prefix ���ļ���ǰ׺
	 * @param suffix ���ļ�����׺
	 */
	public Renamer(String dir, String reg, int begin, int step, String prefix, String suffix) {
		super();
		this.dir = dir;
		this.reg = reg;
		this.begin = begin;
		this.step = step;
		this.prefix = prefix;
		this.suffix = suffix;
	}

	/**
	 * ��������������
	 * @return result �ɹ��������ļ�������
	 * @throws PatternSyntaxException ������ʽģʽ�е��﷨�����쳣
	 * @throws Exception �쳣
	 */
	public int start() throws PatternSyntaxException, Exception {

		if (step == 0) {
			throw new Exception("������ӦΪ������������");
		}

		// ���Ŀ¼����ƥ����ļ����������б�
		addFiles();

		// ������
		if (!rename()) {
			throw new Exception("�����ļ����������ɹ�");
		}

		return result;
	}

	/**
	 * ��Ŀ¼�·���������ʽ���ļ�������������б�
	 */
	private void addFiles() {
		File file = new File(dir);
		for (File f : file.listFiles()) {
			if (f.isFile() && match(f)) {
				files.add(f);
			}
		}
	}

	/**
	 * ������������ȫ��������
	 * @return state ִ��״̬���ɹ�����true�����򷵻�false
	 */
	private boolean rename() {

		boolean state = true;
		int number = begin;

		for (File f : files) {
			String[] parts = f.getName().split("\\.", 0);
			String extension = "";
			if (parts.length > 1) {
				extension = "." + parts[parts.length - 1];
			}
			File newFile = new File(dir + "\\" + prefix + number + suffix + extension);
			if (!f.renameTo(newFile)) {
				state = false;
			} else {
				number += step;
				result++;
			}

		}
		return state;
	}

	/**
	 * ����Ƿ�ƥ��������ʽ
	 * @param file ��Ҫ�����ļ�
	 * @return result ƥ�������ɹ�Ϊtrue��ʧ��Ϊfalse
	 */
	private boolean match(File file) {

		String fileName = file.getName();
		// ����������ʽ
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(fileName);
		// �ļ����Ƿ���������ʽ��ƥ��
		boolean rs = matcher.matches();
		return rs;
	}
	
}
