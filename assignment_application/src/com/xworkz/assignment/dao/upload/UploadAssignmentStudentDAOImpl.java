package com.xworkz.assignment.dao.upload;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.xworkz.assignment.dto.studentupload.UploadStudentAssignmentDTO;
import com.xworkz.assignment.entity.upload.UploadStudentAssignmentEntity;
import com.xworkz.assignment.exception.DAOException;

@Repository
public class UploadAssignmentStudentDAOImpl implements UploadAssignmentStudentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	private static Logger logger = LoggerFactory.getLogger(UploadAssignmentStudentDAOImpl.class);

	@Override
	public String saveFile(UploadStudentAssignmentDTO studentAssignmentDTO) throws DAOException {

		String fileUrl = null;
		BufferedOutputStream outputStream = null;
		try {
			MultipartFile file = studentAssignmentDTO.getFile();
			fileUrl = "G:/assignmentUploadfile/"
					+ new SimpleDateFormat("yyyy.mm.dd.HH.MM.SS").format(new Date()).toString()
					+ studentAssignmentDTO.getEmailId() + ".zip";
			byte[] bytes = file.getBytes();
			outputStream = new BufferedOutputStream(new FileOutputStream(new File(fileUrl)));

			outputStream.write(bytes);
		} catch (IOException e) {
			logger.error("exception from UploadAssignmentStudentDAOImpl " + e.getMessage());
			throw new DAOException(e.getMessage());
		} catch (Exception e) {
			logger.error("exception from UploadAssignmentStudentDAOImpl " + e.getMessage());
			throw new DAOException(e.getMessage());
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					logger.error("exception from UploadAssignmentStudentDAOImpl " + e.getMessage());
					throw new DAOException(e.getMessage());
				}
			}
		}
		return fileUrl;
	}

	@Override
	public boolean saveStudentUpload(UploadStudentAssignmentEntity studentAssignmentEntity) throws DAOException {
		boolean status = true;
		Session session = null;
		Transaction transaction = null;
		logger.info("invoked save student data method");
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Integer id = (Integer) session.save(studentAssignmentEntity);
			if (id != null && id != 0) {
				status = true;
			}
			transaction.commit();
		} catch (HibernateException e) {
			logger.error("exception from UploadAssignmentStudentDAOImpl " + e.getMessage());
			throw new DAOException(e.getMessage());
		} catch (Exception e) {
			logger.error("exception from UploadAssignmentStudentDAOImpl " + e.getMessage());
			throw new DAOException(e.getMessage());
		}

		return status;
	}
}
