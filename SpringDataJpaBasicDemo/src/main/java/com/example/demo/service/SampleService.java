package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Sample;
import com.example.demo.repo.SampleRepository;

@Service
public class SampleService {
	
	private final SampleRepository sampleRepository;

	// �����ڿ� ���� ������ ����
	@Autowired
	public SampleService(SampleRepository sampleRepository) {
		this.sampleRepository = sampleRepository;
	}
	

	// ��� sample ��ü ���
	public List<Sample> getAllSamples(){
		return sampleRepository.findAll();
	}
	
	// id�� sample �ϳ� ���
	public Sample getSample(long id) {
		Optional<Sample> opt = sampleRepository.findById(id);
		
		return opt.orElseThrow(()->{throw new NullPointerException("�ش��ϴ� Sample�� �����ϴ�.");});
	}
	
	// id�� Sample �ϳ� ���(null�� ��ȯ�� �� ����)
	public Sample getSampleOld(long id) {
		return sampleRepository.getById(id);
	}
	
	// Sample �ϳ� �߰�
	public Sample addSample(Sample sample) {
		// save �޼ҵ�� null�� ������� ����
		if(sample == null) {
			throw new NullPointerException("Sample�� Null�� ������� �ʽ��ϴ�.");
		}
		return sampleRepository.save(sample);
	}
	
	// Sample ����
	public Sample updateSample(Sample sample) {
		
		Sample old = getSample(sample.getId());
		old.setName(sample.getName());
		old.setAttr1(sample.getAttr1());
		old.setAttr2(sample.getAttr2());
		
		return sampleRepository.save(sample);
	}
	
	// Sample ����
	public void deleteSample(Sample sample) {
		sampleRepository.delete(sample);
	}
	

}
