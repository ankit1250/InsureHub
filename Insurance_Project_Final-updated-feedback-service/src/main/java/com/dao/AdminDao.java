package com.dao;

import com.entity.AdminFeedback;

public interface AdminDao {
public AdminFeedback addAdminFeedBack(AdminFeedback adminFeedback);
public Iterable<AdminFeedback>getAllFeedBack();

}
