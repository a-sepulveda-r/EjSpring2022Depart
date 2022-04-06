package cl.icap.fullstackjava2022.modulo5.model.dao;

import java.util.List;

import cl.icap.fullstackjava2022.modulo5.model.dto.Departmentsdto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class Departmentsdaoimple implements Departmentsdao {
	private String insert = "INSERT INTO departments VALUES (?,?)";
	private String update = "UPDATE departments SET dept_name=? WHERE dept_no=?";
	private String select = "SELECT * FROM departments WHERE dept_no=?";
	private String delete = "DELETE FROM departments WHERE dept_no=?";
	private String list = "SELECT * FROM departments";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Departmentsdaoimple() {
	}

	@Override
	public int insert(Departmentsdto departmentsdto) {
		return jdbcTemplate.update(insert, new Object[]{departmentsdto.getDept_no(),departmentsdto.getDept_name()});
	}
	@SuppressWarnings("deprecation")
	@Override
	public Departmentsdto get(String dept_no) {		
		return jdbcTemplate.queryForObject(select, new Object[]{dept_no}, BeanPropertyRowMapper.newInstance(Departmentsdto.class));
	}

	@Override
	public int update(Departmentsdto departmentsdto) {
		return jdbcTemplate.update(update, new Object[]{departmentsdto.getDept_name(), departmentsdto.getDept_no()});
	}

	@Override
	public int delete(String dept_no) {
		int vret = 0;
		if (jdbcTemplate.update(delete, new Object[]{dept_no}) == 1) {
			vret = 1;
		}
		return vret;
	}

	@Override
	public List<Departmentsdto> list() {
		List<Departmentsdto> listDepartments = jdbcTemplate.query( list,BeanPropertyRowMapper.newInstance(Departmentsdto.class));
		return listDepartments;
	}

}
