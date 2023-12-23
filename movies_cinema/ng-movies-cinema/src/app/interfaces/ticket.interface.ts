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
}