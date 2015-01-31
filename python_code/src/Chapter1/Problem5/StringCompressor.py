class StringCompressor:
    def __init__(self):
        pass

    @staticmethod
    def compress(string):
        if string is None:
            raise AttributeError("'{}' is not a valid `str`".format(string))
        if len(string) < 3:
            return string

        curr = string[0]
        comp = ""
        count = 0
        for s in string:
            # TODO(arthurb): add a short circuit for when comp is too long
            if s == curr:
                count += 1
            else:
                comp += curr
                comp += str(count)
                count = 1
                curr = s
        comp += curr
        comp += str(count)

        if len(comp) < len(string):
            return comp
        return string
