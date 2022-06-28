package ncstest.service.impl;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ncstest.domain.entity.MemberEntityRepository;
import ncstest.service.SignService;

@RequiredArgsConstructor
@Service
public class SignServiceImpl implements SignService {
	private final MemberEntityRepository memberEntityRepository;
	

}
