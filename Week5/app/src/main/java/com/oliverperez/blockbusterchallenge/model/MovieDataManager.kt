package com.oliverperez.blockbusterchallenge.model

import com.oliverperez.blockbusterchallenge.model.Movie
import com.oliverperez.blockbusterchallenge.R

/*
* Class to manage and provide data related to movie objects
 */
class MovieDataManager {

    private val movies = listOf<Movie>(
        Movie(
            id = 1,
            releaseDate = "July 3, 1985",
            summary = "Back to the Future is a 1985 American science fiction film directed by Robert Zemeckis and written by Zemeckis and Bob Gale. " +
                    "It stars Michael J. Fox as teenager Marty McFly, who accidentally travels back in time from 1985 to 1955, " +
                    "where he meets his future parents and becomes his mother's romantic interest.",
            title = "Back to the future",
            poster = R.drawable.back_to_the_future
        ),
        Movie(
            id = 2,
            releaseDate = "January 19, 2001",
            summary = "Donnie Darko is a 2001 American science fiction psychological thriller film written and directed by Richard Kelly. " +
                    "The film follows the adventures of the troubled titular character as he seeks to find the meaning behind his doomsday-related visions.",
            title = "Donnie Darko",
            poster = R.drawable.donnie_darko
        ),
        Movie(
            id = 3,
            releaseDate = "14 September, 1994",
            summary = "Léon is a hitman (or \"cleaner\", as he refers to himself) living a solitary life in New York City's Little Italy. His work comes from a mafioso named \"Old Tony\".\n" +
                    "One day, Léon meets Mathilda Lando, a lonely 12-year-old girl. " +
                    "Mathilda lives with her dysfunctional family in an apartment down the hall, " +
                    "and has stopped attending class at her school for troubled girls. Mathilda's abusive father attracts the ire of corrupt DEA agents, " +
                    "who have been paying him to stash cocaine in his apartment.",
            title = "Léon: The Professional",
            poster = R.drawable.leon
        ),
        Movie(
            id = 4,
            releaseDate = "April 23, 2004",
            summary = "John W. Creasy (Washington) is former Force Recon Marine and assassin who comes to Mexico to visit his old friend and brother-in-arms, Paul Rayburn (Walken). Rayburn recognizes his friends poor physical and emotional state and convinces him to take a bodyguard position to give him something to do. Creasy reluctantly agrees, and is later offered the job by Samuel Ramos (Anthony), a wealth automaker in Mexico City whose young daughter Lupita “Pita” Ramos (Fanning) requires a bodyguard before she can return to school and the kidnapping insurance policy takes effect.",
            title = "Man on fire",
            poster = R.drawable.man_on_fire
        ),
        Movie(
            id = 5,
            releaseDate = "March 31, 1999",
            summary = "The Matrix is a 1999 science fiction action film written and directed by the Wachowskis.It stars Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss, Hugo Weaving, and Joe Pantoliano and is the first installment in the Matrix franchise. It depicts a dystopian future in which humanity is unknowingly trapped inside a simulated reality, the Matrix, created by intelligent machines to distract humans while using their bodies as an energy source.[5] When computer programmer Thomas Anderson, under the hacker alias \"Neo\", uncovers the truth, he \"is drawn into a rebellion against the machines\" along with other people who have been freed from the Matrix.",
            title = "Matrix",
            poster = R.drawable.matrix
        ),
        Movie(
            id = 6,
            releaseDate = "June 12, 1981",
            summary = "In 1936, American archaeologist Indiana Jones braves an ancient booby-trapped temple in Peru to retrieve a golden idol. After overcoming various challenges, including being betrayed by both of his guides, he is confronted by rival archaeologist René Belloq and the indigenous Hovito people. Surrounded and outnumbered, Jones is forced to surrender the idol to Belloq but manages to escape aboard a waiting seaplane.",
            title = "Raiders of the lost arc",
            poster = R.drawable.raiders_of_the_lost_arc
        ),
        Movie(
            id = 7,
            releaseDate = "20 July, 2001",
            summary = "Chihiro and her parents are moving to a small Japanese town in the countryside, " +
                    "much to Chihiro's dismay. On the way to their new home, Chihiro's father makes a " +
                    "wrong turn and drives down a lonely one-lane road which dead-ends in front of a tunnel.",
            title = "Spirited Away",
            poster = R.drawable.spirited_away
        ),
        Movie(
            id = 8,
            releaseDate = "September 10, 1994",
            summary = "In 1947 Portland, Maine, banker Andy Dufresne is convicted of murdering his wife and her lover and is sentenced to two consecutive life sentences at the Shawshank State Penitentiary. He is befriended by Ellis \"Red\" Redding, an inmate and prison contraband smuggler serving a life sentence. Red procures a rock hammer and a large poster of Rita Hayworth for Andy. Assigned to work in the prison laundry, Andy is frequently sexually assaulted by \"the Sisters\" and their leader, Bogs.",
            title = "The Shawshank Redemption",
            poster = R.drawable.the_shawshank_redemption
        )
    )

    /**
     * Returns a List of Movie objects
     */
    fun getMovies(): List<Movie> {
        return movies
    }
}