package com.vinisolon.exception.mapper;

import com.vinisolon.exception.ObjectNotFoundException;
import io.netty.handler.codec.http.HttpResponseStatus;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.time.LocalDateTime;

@Provider
public class EntityNotFoundExceptionMapper implements ExceptionMapper<ObjectNotFoundException> {
    @Override
    public Response toResponse(ObjectNotFoundException e) {
        StandardError error = new StandardError(
                HttpResponseStatus.NOT_FOUND.code(),
                LocalDateTime.now(),
                e.getMessage()
        );
        return Response.status(Response.Status.NOT_FOUND).entity(error).build();
    }
}
