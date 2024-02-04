package com.uningen.aspects;

import com.uningen.aspects.domain.Comment;
import com.uningen.aspects.service.CommentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AspectsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(AspectsApplication.class, args);

		CommentService commentService =
				ctx.getBean(CommentService.class);
		Comment comment = new Comment();
		comment.setText("Demo comment");
		comment.setAuthor("Vladimir Solovyov");

		String val = commentService.publishComment(comment);
		System.out.println(val);
	}

}
