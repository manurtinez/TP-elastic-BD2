package manu.pruebaelastic.model.DTO;

import java.util.Date;

/**
 * Esta clase representa un rango de fechas, para ser usado en requests que lo
 * requieran
 */
public class PeriodDTO {
  private Date start;
  private Date end;

  public PeriodDTO(Date start, Date end) {
    this.start = start;
    this.end = end;
  }

  public Date getStart() {
    return this.start;
  }

  public Date getEnd() {
    return this.end;
  }
}
