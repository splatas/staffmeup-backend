package com.postres.staffing_follower.repository;

import com.postres.staffing_follower.entity.TicketHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface TicketHistoryRepo extends JpaRepository<TicketHistory, Long> {

    List<TicketHistory> findAllByIdTicketHistory(Long idTicketHistory);

    List<TicketHistory> findByIdTicket(Long idTicket);

    List<TicketHistory> findAllByOrderByIdTicketAscUpdateDateDesc();

    List<TicketHistory> findByUpdateDateBetween(Date from, Date to);

    List<TicketHistory> findByUpdateDateLessThanEqualOrderByIdTicketAsc(Date date);

    List<TicketHistory> findByStatusAndProfile(String status, String profile);

    @Query(value = "select t.id_ticket_history, t.created_on, t.description, t.id_ticket, t.location, t.position, t.profile, t.project, t.seniority, t.start_date, t.status, t.update_date " +
            "from ticket_history t " +
            "where (t.id_ticket_history, t.update_date) in (select max(temp.id_ticket_history), max(temp.update_date) " +
            "                                              from ticket_history temp " +
            "                                              where temp.update_date <= :updateDate " +
            "                                              group by temp.id_ticket)", nativeQuery = true)
    List<TicketHistory> getTicketsByUpdateDate(@Param("updateDate") Date updateDate);

    @Query(value =  "select q.id_ticket_history, q.id_ticket, q.project, q.description, q.profile, q.seniority, q.position, q.created_on, q.start_date, q.location, q.status, q.update_date \n" +
                    "from ( \n" +
                    "       select t.id_ticket_history, t.id_ticket, t.project, t.description, t.profile, t.seniority, t.position, t.created_on, t.start_date, t.location, t.status, t.update_date \n" +
                    "       from ticket_history t \n" +
                    "       where (t.id_ticket_history, t.update_date) in (select max(temp.id_ticket_history), max(temp.update_date) \n" +
                    "                                                      from ticket_history temp \n" +
                    "                                                      where temp.update_date <= :dateOne \n" +
                    "                                                      group by temp.id_ticket) \n" +
                    "\n" +
                    "       union \n" +
                    "\n" +
                    "       select t.id_ticket_history, t.id_ticket, t.project, t.description, t.profile, t.seniority, t.position, t.created_on, t.start_date, t.location, t.status, t.update_date \n" +
                    "       from ticket_history t \n" +
                    "       where (t.id_ticket_history, t.update_date) in (select max(temp.id_ticket_history), max(temp.update_date) \n" +
                    "                                                      from ticket_history temp \n" +
                    "                                                      where temp.update_date between :dateOne and :dateTwo \n" +
                    "                                                      group by temp.id_ticket)\n" +
                    "     ) q \n" +
                    "order by q.id_ticket asc, q.update_date asc", nativeQuery = true)
    List<TicketHistory> getAllTheTicketsToCompare( @Param("dateOne") Date dateOne
                                                  ,@Param("dateTwo") Date dateTwo );

    @Query(value =  "select q.id_ticket_history, q.id_ticket, q.project, q.description, q.profile, q.seniority, q.position, q.created_on, q.start_date, q.location, q.status, q.update_date \n" +
            "from ( \n" +
            "       select t.id_ticket_history, t.id_ticket, t.project, t.description, t.profile, t.seniority, t.position, t.created_on, t.start_date, t.location, t.status, t.update_date \n" +
            "       from ticket_history t \n" +
            "       where (t.id_ticket_history, t.update_date) in (select max(temp.id_ticket_history), max(temp.update_date) \n" +
            "                                                      from ticket_history temp \n" +
            "                                                      where temp.update_date <= :dateOne \n" +
            "                                                      group by temp.id_ticket) \n" +
            "\n" +
            "       union \n" +
            "\n" +
            "       select t.id_ticket_history, t.id_ticket, t.project, t.description, t.profile, t.seniority, t.position, t.created_on, t.start_date, t.location, t.status, t.update_date \n" +
            "       from ticket_history t \n" +
            "       where (t.id_ticket_history, t.update_date) in (select max(temp.id_ticket_history), max(temp.update_date) \n" +
            "                                                      from ticket_history temp \n" +
            "                                                      where temp.update_date between :dateOne and :dateTwo \n" +
            "                                                      group by temp.id_ticket)\n" +
            "     ) q \n" +
            "where q.id_ticket = :idTicket \n" +
            "order by q.id_ticket asc, q.update_date asc", nativeQuery = true)
    List<TicketHistory> getATicketToCompare( @Param("idTicket") Long idTicket
                                            ,@Param("dateOne") Date dateOne
                                            ,@Param("dateTwo") Date dateTwo );

    @Query(value = "select t.id_ticket_history, t.id_ticket, t.project, t.description, t.profile, t.seniority, t.position, t.created_on, t.start_date, t.location, t.status, t.update_date\n" +
                   "from ticket_history t\n" +
                   "where (t.id_ticket_history, t.update_date) in (select max(tmp.id_ticket_history), max(tmp.update_date)\n" +
                   "                                               from ticket_history tmp\n" +
                   "                                               group by tmp.id_ticket)", nativeQuery = true)
    List<TicketHistory> getTheLastUpdate();



}
