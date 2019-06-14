package com.group23.minir.core;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
* 重命名核心功能类
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
	 * 构造方法
	 * @param dir 重命名文件所在目录
	 * @param reg 选择文件所使用的正则表达式
	 * @param begin 起始编号
	 * @param step 编号步长
	 * @param prefix 新文件名前缀
	 * @param suffix 新文件名后缀
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
	 * 重命名启动方法
	 * @return result 成功重命名文件的数量
	 * @throws PatternSyntaxException 正则表达式模式中的语法错误异常
	 * @throws Exception 异常
	 */
	public int start() throws PatternSyntaxException, Exception {

		if (step == 0) {
			throw new Exception("编码间距应为非零正整数！");
		}

		// 添加目录下所匹配的文件到待处理列表
		addFiles();

		// 重命名
		if (!rename()) {
			throw new Exception("部分文件重命名不成功");
		}

		return result;
	}

	/**
	 * 将目录下符合正则表达式的文件添加至待处理列表
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
	 * 重命名方法，全部重命名
	 * @return state 执行状态，成功返回true，否则返回false
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
	 * 检查是否匹配正则表达式
	 * @param file 需要检查的文件
	 * @return result 匹配结果，成功为true，失败为false
	 */
	private boolean match(File file) {

		String fileName = file.getName();
		// 编译正则表达式
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(fileName);
		// 文件名是否与正则表达式相匹配
		boolean rs = matcher.matches();
		return rs;
	}
	
}
