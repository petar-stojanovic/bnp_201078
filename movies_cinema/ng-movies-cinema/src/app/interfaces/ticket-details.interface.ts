export interface TicketDetails {
  id: number
  price: number
  paymentMethod: string
  seat: Seat
  projection: Projection
  customer: Customer
}

export interface Seat {
  id: Id
  seatRow: number
  seatNumber: number
}

export interface Id {
  seatId: number
  hallId: number
}

export interface Projection {
  id: number
  dateTime: string
  movie: Movie
  hall: Hall
  startPrice: number
}

export interface Movie {
  id: number
  title: string
  duration: number
  description: string
  rating: number
  specialRequirement: string
  poster: string
}

export interface Hall {
  id: number
  hallNumber: number
  screenType: string
  cinema: Cinema
}

export interface Cinema {
  id: number
  name: string
  address: string
  city: string
  country: string
}

export interface Customer {
  id: number
  firstName: string
  lastName: string
  sex: string
  age: number
}
