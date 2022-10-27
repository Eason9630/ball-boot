package com.tibame.ball.member.dao.impl;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tibame.ball.member.dao.MemberDAO;
import com.tibame.ball.member.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Autowired
	private DataSource dataSource;
	
	@PersistenceContext
	private Session session;
	
	public Session getSession() {
		return session;
	}
	
	
	@Override
	public List<MemberVO> getAll() {
		String sql = "FROM MemberVO";
		Query<MemberVO> query = getSession().createQuery(sql,MemberVO.class);
		List<MemberVO> list = query.list();
		for(MemberVO member : list) {
			System.out.println(member);
		}
//		try
//		(Connection connection = dataSource.getConnection();
//				PreparedStatement ps = connection.prepareStatement(sql)){
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				MemberVO member = new MemberVO();
//				member.setId(rs.getInt("id"));
//				member.setUsername(rs.getString("username"));
//				member.setPassword(rs.getString("password"));
//				member.setNickname(rs.getString("nickname"));
//				member.setBirthday(rs.getObject("birthday", LocalDate.class));
//				member.setBase64img(rs.getString("img"));
//				list.add(member);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null;
//		}
		return list;
		
	}

	@Override
	public MemberVO insert(MemberVO member) {
//		int rowCount = 0;
//		String sql = "insert into member(username,password,nickname,birthday,img) values(?,?,?,?,?);";
		try
//		(Connection connection = dataSource.getConnection();
//				PreparedStatement ps = connection.prepareStatement(sql))
		{
			getSession().persist(member);
			
			return member;
//			ps.setString(1, member.getUsername());
//			ps.setString(2, member.getPassword());
//			ps.setString(3, member.getNickname());
//			ps.setObject(4, member.getBirthday());
//			ps.setBytes(5, member.getBase64img().getBytes());
//			rowCount = ps.executeUpdate();
//			return rowCount==1;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public MemberVO update(MemberVO member) {
//		String sql = "update member set password = ?,nickname = ?, img = ? where id = ?;";
		try
//		(Connection connection = dataSource.getConnection();
//				PreparedStatement ps = connection.prepareStatement(sql))
		{
			MemberVO memberVO = getSession().load(MemberVO.class,member.getId());
			
			memberVO.setPassword(member.getPassword());
			memberVO.setNickname(member.getNickname());
			memberVO.setBase64img(member.getBase64img());
			return memberVO;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public MemberVO delete(Integer id) {
//		String sql = "delete from member where id = ?;";
		try
//		(Connection connection = dataSource.getConnection();
//				PreparedStatement ps = connection.prepareStatement(sql))
		{
			MemberVO member = getSession().load(MemberVO.class, id);
			 getSession().remove(member);
			 return member;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public MemberVO findById(Integer id) {
		return null;
	}

}
