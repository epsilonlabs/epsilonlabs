package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
/**
 * 
 * @author http://stackoverflow.com/questions/106770/standard-concise-way-to-copy-a-file-in-java
 * accessed: 8/12/2011, 13:15gmt
 *
 */
public class CopyFile {

	/**
	 * Copies a file (sourceFile) to another file (destFile)
	 * @param sourceFile
	 * @param destFile
	 * @throws IOException
	 */
	public void copyFile(File sourceFile, File destFile)
			throws IOException {
		if (!destFile.exists()) {
			destFile.createNewFile();
		}
		FileChannel source = null;
		FileChannel destination = null;
		try {
			source = new FileInputStream(sourceFile).getChannel();
			destination = new FileOutputStream(destFile).getChannel();
			destination.transferFrom(source, 0, source.size());
		} finally {
			if (source != null) {
				source.close();
			}
			if (destination != null) {
				destination.close();
			}
		}
	}

}
