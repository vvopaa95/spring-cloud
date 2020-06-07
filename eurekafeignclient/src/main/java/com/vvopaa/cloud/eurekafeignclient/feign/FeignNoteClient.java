package com.vvopaa.cloud.eurekafeignclient.feign;

import com.vvopaa.cloud.general.clienttemplate.NoteClient;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("spring-cloud-eureka-client")
public interface FeignNoteClient extends NoteClient {

}
