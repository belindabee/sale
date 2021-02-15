package com.glints.Assesment4.service;

import java.util.List;


import com.glints.Assesment4.model.Member;
import com.glints.Assesment4.payload.MemberPayload;

public interface MemberService {
	public List<Member> read();
	public Member create(MemberPayload memberPayload);
	public Member update(Integer id, MemberPayload memberPayload);
	public String delete(Integer id);
	public Member readById(Integer id);
}
