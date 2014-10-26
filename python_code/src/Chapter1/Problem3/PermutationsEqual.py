class PermutationsEqual:
    def __init__(self):
        pass

    @staticmethod
    def permutations_equal(str_a, str_b):
        if str_a is None or str_b is None:
            raise AttributeError("inputs must be valid str")
        if len(str_a) != len(str_b):
            return False

        tracker = {k: 0 for k in str_a}

        for s in str_a:
            tracker[s] += 1
        for s in str_b:
            if tracker.get(s) is None:
                return False
            tracker[s] -= 1
            if tracker[s] < 0:
                return False

        return sum(tracker[k] for k in tracker) == 0
