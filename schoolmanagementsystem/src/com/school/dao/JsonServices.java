package com.school.dao;

import java.sql.ResultSet;
import java.util.List;

import org.json.JSONObject;

public interface JsonServices {
public List<JSONObject> getFormattedResultSet(ResultSet rs);
}
