package com.poticard.api.portfolio.model;

import java.util.List;

public class PortfolioDto {

    // [Request] 프로젝트 작성
    public static class CreateRequest {
        private Long userId;
        private String title;
        private String period;
        private List<SectionRequest> sections;

        public Long getUserId() { return userId; }
        public void setUserId(Long userId) { this.userId = userId; }
        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }
        public String getPeriod() { return period; }
        public void setPeriod(String period) { this.period = period; }
        public List<SectionRequest> getSections() { return sections; }
        public void setSections(List<SectionRequest> sections) { this.sections = sections; }
    }

    public static class SectionRequest {
        private String sectionType;
        private String sectionTitle;
        private String bodyMarkdown;
        private Integer sortOrder;

        public String getSectionType() { return sectionType; }
        public void setSectionType(String sectionType) { this.sectionType = sectionType; }
        public String getSectionTitle() { return sectionTitle; }
        public void setSectionTitle(String sectionTitle) { this.sectionTitle = sectionTitle; }
        public String getBodyMarkdown() { return bodyMarkdown; }
        public void setBodyMarkdown(String bodyMarkdown) { this.bodyMarkdown = bodyMarkdown; }
        public Integer getSortOrder() { return sortOrder; }
        public void setSortOrder(Integer sortOrder) { this.sortOrder = sortOrder; }
    }
}