package com.cos.photogramstart.web.dto.subscribe;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SubscribeDto {
	
	private int Id;
	private String username;
	private String profileImageUrl;
	private Integer subscribeState;
	private Integer equalUserState;
	
}
