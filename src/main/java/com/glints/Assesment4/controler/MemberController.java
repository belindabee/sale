package com.glints.Assesment4.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glints.Assesment4.model.Member;
import com.glints.Assesment4.service.MemberService;
import com.glints.Assesment4.payload.MemberPayload;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class MemberController {
	
	@Autowired
	MemberService memberservice;
	
	@GetMapping("/member")
	public ResponseEntity<List<Member>> read(){
		List<Member> members = memberservice.read();
		return new ResponseEntity<List<Member>>(members, HttpStatus.OK);
	}
	
	@PostMapping("/create-member")
	public ResponseEntity<Member> create(@Valid @RequestBody MemberPayload memberPayload){
		Member member = memberservice.create(memberPayload);
		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}
	
	@PostMapping("/update-member/{id}")
	public ResponseEntity<Member> update(@PathVariable("id") Integer id, @RequestBody MemberPayload memberPayload){
		Member member;
		member = memberservice.update(id, memberPayload);
		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-member/{id}")
	public String delete(@PathVariable("id") Integer id) {
		memberservice.delete(id);
		return "Member with data id: " + id + " has been deleted!";
	}
	
	@GetMapping("/member/{id}")
	public ResponseEntity<Member> readById(@PathVariable("id") Integer id){
		Member member = memberservice.readById(id);
		return new ResponseEntity<Member>(member, HttpStatus.OK); 
	}
	

}
