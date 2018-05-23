package com.xie.work.domain;

import javax.persistence.*;

@Entity
@Table(name = "evaluate", schema = "platform", catalog = "")
public class EvaluateEntity {
    private long eid;
    private Long teamId;
    private Long mateId;
    private Long userId;
    private Long score;
    private String reason;

    @Id
    @Column(name = "eid")
    public long getEid() {
        return eid;
    }

    public void setEid(long eid) {
        this.eid = eid;
    }

    @Basic
    @Column(name = "team_id")
    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    @Basic
    @Column(name = "mate_id")
    public Long getMateId() {
        return mateId;
    }

    public void setMateId(Long mateId) {
        this.mateId = mateId;
    }

    @Basic
    @Column(name = "user_id")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "score")
    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    @Basic
    @Column(name = "reason")
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EvaluateEntity that = (EvaluateEntity) o;

        if (eid != that.eid) return false;
        if (teamId != null ? !teamId.equals(that.teamId) : that.teamId != null) return false;
        if (mateId != null ? !mateId.equals(that.mateId) : that.mateId != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (score != null ? !score.equals(that.score) : that.score != null) return false;
        if (reason != null ? !reason.equals(that.reason) : that.reason != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (eid ^ (eid >>> 32));
        result = 31 * result + (teamId != null ? teamId.hashCode() : 0);
        result = 31 * result + (mateId != null ? mateId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        return result;
    }
}
