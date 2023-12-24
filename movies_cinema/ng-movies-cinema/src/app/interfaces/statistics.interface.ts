export interface Statistics {
  mostViewedMovies: MostViewedMovies[]
  mostPopularGenres: MostPopularGenre[]
  mostFrequentCustomers: MostFrequentCustomer[]
  mostProfitableMovies: MostProfitableMovies[]
  mostPopularMovieTimes: MostPopularMovieTime[]
}

export interface MostViewedMovies {
  id: number
  movieId: number
  poster: string
  title: string
  ticketCount: number
}


export interface MostPopularGenre {
  id: number
  name: string
  ticketCount: number
}

export interface MostFrequentCustomer {
  id: number
  movieId: number
  firstName: string
  lastName: string
  ticketCount: number
}


export interface MostProfitableMovies {
  id: number
  movieId: number
  poster: string
  title: string
  totalRevenue: number
}

export interface MostPopularMovieTime {
  id: number
  projectionTime: string
  ticketCount: number
}
