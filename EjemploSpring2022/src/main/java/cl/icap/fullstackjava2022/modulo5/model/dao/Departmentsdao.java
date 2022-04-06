package cl.icap.fullstackjava2022.modulo5.model.dao;

import java.util.List;

import cl.icap.fullstackjava2022.modulo5.model.dto.Departmentsdto;

public interface Departmentsdao {
	public int insert (Departmentsdto departmentsdto);
	public Departmentsdto get(String dept_no);
	public int update(Departmentsdto departmentsdto);
	public int delete(String dept_no);
	public List<Departmentsdto> list();
}
