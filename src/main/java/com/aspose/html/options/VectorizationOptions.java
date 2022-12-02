package com.aspose.html.options;

import java.util.Optional;

public class VectorizationOptions implements Options {
    public Optional<Double> error_threshold = Optional.empty();
    public Optional<Integer> max_iterations = Optional.empty();
    public Optional<Integer> colors_limit = Optional.empty();
    public Optional<Double> line_width = Optional.empty();

    public VectorizationOptions()
    {
    }

    public VectorizationOptions setErrorThreshold(double error_threshold)
    {
        this.error_threshold = Optional.of(error_threshold);
        return this;
    }

    public VectorizationOptions setMaxIteration(int max_iterations)
    {
        this.max_iterations = Optional.of(max_iterations);
        return this;
    }

    public VectorizationOptions setColorLimit(int colors_limit)
    {
        this.colors_limit = Optional.of(colors_limit);
        return this;
    }

    public VectorizationOptions setLineWidth(double line_width)
    {
        this.line_width = Optional.of(line_width);
        return this;
    }
}
