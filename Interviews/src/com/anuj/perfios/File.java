package com.anuj.perfios;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class File {
	String fileName = new String();
	String extension = new String();
	long size = 0;
	Calendar createdTime = Calendar.getInstance();
	Calendar modifiedTime = Calendar.getInstance();
	Calendar lastAccessTime = Calendar.getInstance();
	boolean readOnly = false;
	boolean hidden = false;
	boolean isExecutable = false;

	boolean isFolder = false;
	File upperLevel = null;
	Set<File> children = new HashSet<File>();
	String content = null;

	public String getContent() {
		if (isFolder) {
			StringBuilder fileList = new StringBuilder();
			Iterator<File> itr = children.iterator();
			while (itr.hasNext()) {
				fileList.append(itr.next().fileName);
			}
			return fileList.toString();
		} else
			return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void appendContent(String contentToAppend) {
		if (!isFolder) {
			content = content + contentToAppend;
		}
	}

	public String getName() {
		if (isFolder)
			return fileName;
		else
			return fileName + "." + extension;
	}

	@Override
	public String toString() {
		String appendix = isFolder ? "/" : "." + extension;
		return fileName + appendix;
	}
}