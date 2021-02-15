package com.glints.Assesment4.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glints.Assesment4.model.Member;
import com.glints.Assesment4.payload.MemberPayload;
import com.glints.Assesment4.repository.MemberRepo;



@Service
public class MemberServiceImpl implements MemberService {
	
@Autowired
MemberRepo memberrepo;

@Override
public List<Member> read() {
	List<Member> members = memberrepo.findAll();
	return members;
}

	@Override
	public Member create(MemberPayload memberPayload){
		Member member = new Member(
				memberPayload.getFirstname(), 
				memberPayload.getSurname(),
				memberPayload.getAddress(),
				memberPayload.getContact(),
				memberPayload.getExpires()
				);
		member = memberrepo.save(member);
		return member;
	}
		
	@Override
	public Member update(Integer id, MemberPayload memberPayload) {
		Member member = memberrepo.findById(id).orElse(null);
		member.setFirstname(memberPayload.getFirstname());
		member.setSurname(memberPayload.getSurname());
		member.setAddress(memberPayload.getAddress());
		member.setContact(memberPayload.getContact());
		member.setExpires(memberPayload.getExpires());
		member.setUpdatedTime(new Date());
		member = memberrepo.save(member);
		return member;
	}


	@Override
	public String delete(Integer id) {
		memberrepo.deleteById(id);
		return "Member with data id: " + id + " has been deleted!";
	}

	@Override
	public Member readById(Integer id) {
		Member member = memberrepo.findById(id).orElse(null);
		return member;
	}

}
