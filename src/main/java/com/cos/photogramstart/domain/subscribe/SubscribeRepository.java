package com.cos.photogramstart.domain.subscribe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface SubscribeRepository extends JpaRepository<Subscribe, Integer> {
	
	@Modifying
	@Query(value = "insert into subscribe(fromUserId, toUserId, createDate) values(:fromUserId, :toUserId, now())", nativeQuery = true)
	int mSubscribe(int fromUserId, int toUserId);
	
	@Modifying
	@Query(value = "delete from subscribe where fromUserId = :fromUserId and toUserId = :toUserId", nativeQuery = true)
	int mUnSubscribe(int fromUserId, int toUserId);
	
	@Query(value = "select count(*) from subscribe where fromUserId = :principalId and toUserId = :pageUserId", nativeQuery = true)
	int mSubscribeState(int principalId, int pageUserId);
	
	@Query(value = "select count(*) from subscribe where fromUserId =  :pageUserId", nativeQuery = true)
	int mSubscribeCount(int pageUserId);
	
}
