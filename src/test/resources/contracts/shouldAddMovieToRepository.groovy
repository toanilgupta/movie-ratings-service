package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should get movie to repository"
    request{
        method GET()
        url("/movies") {
            body("")
        }
    }
    response {
        body("[[{\"movieId\":\"Thappad\",\"movieName\":\"Thappad\",\"yearOfMaking\":\"2020\",\"description\":\"Direction\"},{\"movieId\":\"Article15\",\"movieName\":\"Article15\",\"yearOfMaking\":\"2019\",\"description\":\"Awesome\"}]]")
        status 200
    }
}
