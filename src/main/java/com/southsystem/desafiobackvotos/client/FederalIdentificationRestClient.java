package com.southsystem.desafiobackvotos.client;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.southsystem.desafiobackvotos.api.exception.generic.NotFoundException;
import com.southsystem.desafiobackvotos.entity.AbleToVoteStatus;
import com.southsystem.desafiobackvotos.service.AbleToVoteResponseVO;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.HttpUrl.Builder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

@Component
public class FederalIdentificationRestClient {
    private static final String BASE_URL = "https://user-info.herokuapp.com/users";
    private OkHttpClient client = new OkHttpClient();
    private ObjectMapper objectMapper = new ObjectMapper();

    public AbleToVoteStatus verifyAssociateAbleVote(String federalIdentification) {
        Builder urlBuilder = HttpUrl.parse(BASE_URL + "/" + federalIdentification)
                .newBuilder();

        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);

        try {
            Response response = call.execute();

            AbleToVoteResponseVO responseVO = objectMapper.readValue(response.body().string(), AbleToVoteResponseVO.class);

            return AbleToVoteStatus.valueOf(responseVO.getStatus());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //TODO: trocar exception
       throw new NotFoundException("teste");
    }
}
