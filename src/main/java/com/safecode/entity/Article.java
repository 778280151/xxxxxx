package com.safecode.entity;

import java.sql.Timestamp;

public class Article {
		
		private int a_id;
		private int u_id;
		private Long w_id;
		private String w_title;
		private String w_content;
		private String u_nickname;
		
		
		public String getU_nickname() {
			return u_nickname;
		}


		public void setU_nickname(String u_nickname) {
			this.u_nickname = u_nickname;
		}


		public Long getW_id() {
			return w_id;
		}


		public void setW_id(Long w_id) {
			this.w_id = w_id;
		}


		public Article() {
			super();
		}
	
	
		public Article(int a_id, int u_id, Long w_id, String w_title, String w_content) {
			super();
			this.a_id = a_id;
			this.u_id = u_id;
			this.w_id = w_id;
			this.w_title = w_title;
			this.w_content = w_content;
		}

	
		@Override
		public String toString() {
			return "Article [a_id=" + a_id + ", u_id=" + u_id + ", w_id=" + w_id + ", w_title=" + w_title
					+ ", w_content=" + w_content + "]";
		}
		public int getU_id() {
			return u_id;
		}
		public void setU_id(int u_id) {
			this.u_id = u_id;
		}
		public int getA_id() {
			return a_id;
		}
		public void setA_id(int a_id) {
			this.a_id = a_id;
		}
	
		public String getW_title() {
			return w_title;
		}
		public void setW_title(String w_title) {
			this.w_title = w_title;
		}
		public String getW_content() {
			return w_content;
		}
		public void setW_content(String w_content) {
			this.w_content = w_content;
		}
		
}
