package com.cictec.yyjk.base.model.view;

import java.util.ArrayList;
import java.util.List;

public class BaseBusVideoInfoViewValue {
	private String busUuid;
	private List<BusVideoRelation> relationList = new ArrayList<>();

	public String getBusUuid() {
		return busUuid;
	}

	public void setBusUuid(String busUuid) {
		this.busUuid = busUuid;
	}

	public List<BusVideoRelation> getRelationList() {
		return relationList;
	}

	public void setRelationList(List<BusVideoRelation> relationList) {
		this.relationList = relationList;
	}


	class BusVideoRelation {
		private String videoDefaultSite;
		private String videoRealSite;

		public String getVideoDefaultSite() {
			return videoDefaultSite;
		}

		public void setVideoDefaultSite(String videoDefaultSite) {
			this.videoDefaultSite = videoDefaultSite;
		}

		public String getVideoRealSite() {
			return videoRealSite;
		}

		public void setVideoRealSite(String videoRealSite) {
			this.videoRealSite = videoRealSite;
		}
	}
}
