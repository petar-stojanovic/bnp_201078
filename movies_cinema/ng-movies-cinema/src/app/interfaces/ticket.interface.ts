export interface Ticket {
  id: number
  projectionId: number
  ticketId: number
  projectionTime: string
  price: number
  seatId: number
  seatRow: number
  seatNumber: number
  isBought: boolean
  screenType: string
  cinemaName: string
  city: string
  country: string
  hallNumber: number
}

export interface BoughtTicketInfo {
  id: number
  customerId: number
  dateTime: string
  poster: string
  movieTitle: string
  specialRequirement: string
  ticketPrice: number
  paymentMethod: string
  rowNumber: number
  colNumber: number
  screenType: string
  cinemaName: string
}
