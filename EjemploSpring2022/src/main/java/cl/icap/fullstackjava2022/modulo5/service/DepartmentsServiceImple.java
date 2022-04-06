package cl.icap.fullstackjava2022.modulo5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.icap.fullstackjava2022.modulo5.model.dao.Departmentsdao;
import cl.icap.fullstackjava2022.modulo5.model.dto.Departmentsdto;

@Service
public class DepartmentsServiceImple implements DepartmentsService {
	@Autowired
	Departmentsdao departmentsdao;

	public DepartmentsServiceImple() {
	}

	@Override
	public int insert(Departmentsdto departmentsdto) {
		return departmentsdao.insert(departmentsdto);
	}

	@Override
	public Departmentsdto get(String dept_no) {	
		return departmentsdao.get(dept_no);
	}

	@Override
	public int update(Departmentsdto departmentsdto) {
		return departmentsdao.update(departmentsdto);
	}

	@Override
	public int delete(String dept_no) {
		return departmentsdao.delete(dept_no);
	}

	@Override
	public List<Departmentsdto> list() {
		// TODO Auto-generated method stub
		return departmentsdao.list();
	}

}
