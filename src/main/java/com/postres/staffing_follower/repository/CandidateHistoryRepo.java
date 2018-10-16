package com.postres.staffing_follower.repository;

import com.postres.staffing_follower.entity.CandidateHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface CandidateHistoryRepo extends JpaRepository<CandidateHistory, Long> {

    List<CandidateHistory> findAllByIdCandidateHistory(Long idCandidateHistory);

    List<CandidateHistory> findByIdCandidate(Long idCandidate);

    List<CandidateHistory> findAllByOrderByIdCandidateAscUpdateDateDesc();

    @Query(value = "select q.id_candidate_history, q.id_candidate, q.nombre, q.ticket, q.interview, q.onboarding, q.priority, q.real_attibute, q.comment, q.candidate_status, q.main_area, q.project, q.level, q.update_date \n" +
                   "from ( \n" +
                   "      select c.id_candidate_history, c.id_candidate, c.nombre, c.ticket, c.interview, c.onboarding, c.priority, c.real_attibute, c.comment, c.candidate_status, c.main_area, c.project, c.level, c.update_date \n" +
                   "      from candidate_history c \n" +
                   "      where (c.id_candidate_history, c.update_date) in (select max(temp.id_candidate_history), max(temp.update_date) \n" +
                   "                                                        from candidate_history temp \n" +
                   "                                                        where temp.update_date <= :dateOne \n" +
                   "                                                        group by temp.id_candidate) \n" +
                   "\n" +
                   "      union \n" +
                   "\n" +
                   "      select c.id_candidate_history, c.id_candidate, c.nombre, c.ticket, c.interview, c.onboarding, c.priority, c.real_attibute, c.comment, c.candidate_status, c.main_area, c.project, c.level, c.update_date \n" +
                   "      from candidate_history c \n" +
                   "      where (c.id_candidate_history, c.update_date) in (select max(temp.id_candidate_history), max(temp.update_date) \n" +
                   "                                                        from candidate_history temp \n" +
                   "                                                        where temp.update_date between :dateOne and :dateTwo \n" +
                   "                                                        group by temp.id_candidate) \n" +
                   "     ) q \n" +
                   "order by q.id_candidate asc, q.update_date asc", nativeQuery = true)
    List<CandidateHistory> getAllTheCandidatesToCompare( @Param("dateOne") Date dateOne
                                                        ,@Param("dateTwo") Date dateTwo );

    @Query(value = "select q.id_candidate_history, q.id_candidate, q.nombre, q.ticket, q.interview, q.onboarding, q.priority, q.real_attibute, q.comment, q.candidate_status, q.main_area, q.project, q.level, q.update_date \n" +
            "from ( \n" +
            "      select c.id_candidate_history, c.id_candidate, c.nombre, c.ticket, c.interview, c.onboarding, c.priority, c.real_attibute, c.comment, c.candidate_status, c.main_area, c.project, c.level, c.update_date \n" +
            "      from candidate_history c \n" +
            "      where (c.id_candidate_history, c.update_date) in (select max(temp.id_candidate_history), max(temp.update_date) \n" +
            "                                                        from candidate_history temp \n" +
            "                                                        where temp.update_date <= :dateOne \n" +
            "                                                        group by temp.id_candidate) \n" +
            "\n" +
            "      union \n" +
            "\n" +
            "      select c.id_candidate_history, c.id_candidate, c.nombre, c.ticket, c.interview, c.onboarding, c.priority, c.real_attibute, c.comment, c.candidate_status, c.main_area, c.project, c.level, c.update_date \n" +
            "      from candidate_history c \n" +
            "      where (c.id_candidate_history, c.update_date) in (select max(temp.id_candidate_history), max(temp.update_date) \n" +
            "                                                        from candidate_history temp \n" +
            "                                                        where temp.update_date between :dateOne and :dateTwo \n" +
            "                                                        group by temp.id_candidate) \n" +
            "     ) q \n" +
            "where q.ticket = :idTicket \n" +
            "order by q.id_candidate asc, q.update_date asc", nativeQuery = true)
    List<CandidateHistory> getAllTheCandidatesToCompareByTicket( @Param("idTicket") Long idTicket
                                                                ,@Param("dateOne") Date dateOne
                                                                ,@Param("dateTwo") Date dateTwo );


}
